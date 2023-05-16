package controller;

import common.exception.ExpiredSessionException;
import common.exception.FailLoginException;
import dao.user.UserDAO;
import entity.user.User;
import utils.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * @author
 */
public class AuthenticationController extends BaseController {

    public boolean isAnonymousSession() {
        try {
            getMainUser();
            return false;
        } catch (Exception ex) {
            return true;
        }
    }
    /*
    /    common coupling vì hàm getMainUser sử dụng chung global data từ class SessionInformation là mainUser va expiredTime
     */
    public User getMainUser() throws ExpiredSessionException {
        if (SessionInformation.mainUser == null || SessionInformation.expiredTime == null || SessionInformation.expiredTime.isBefore(LocalDateTime.now())) {
            logout();
            throw new ExpiredSessionException();
        } else return SessionInformation.mainUser.cloneInformation();
    }
    /*
    /
        common coupling vì hàm login  sử dụng chung global data từ class SessionInformation mainUser va expiredTime
     */
    public void login(String email, String password) throws Exception {
        try {
            User user = new UserDAO().authenticate(email, md5(password));
            if (Objects.isNull(user)) throw new FailLoginException();
            SessionInformation.mainUser = user; /* content coupling: sử dụng trực tiếp mainUser của lớp SessionInformation*/
            SessionInformation.expiredTime = LocalDateTime.now().plusHours(24); /* content coupling: sử dụng trực tiếp expiredTime của lớp SessionInformation*/
        } catch (SQLException ex) {
            throw new FailLoginException();
        }
    }
    /*
    /    common coupling vì hàm logout sử dụng chung global data từ class SessionInformation là mainUser va expiredTime
     */
 // Procedural Cohesion vì phương thức logout() được nhóm lại trong Class này để tuân theo trình tự thực thi từ login -> Logout
    public void logout() {
        SessionInformation.mainUser = null; /* content coupling: sử dụng trực tiếp mainUser của lớp SessionInformation*/
        SessionInformation.expiredTime = null; /* content coupling: sử dụng trực tiếp expiredTime của lớp SessionInformation*/
    }
    /* content coupling: sử dụng trực tiếp mainUser, expiredTime của lớp SessionInformation*/
    /**
     * Return a {@link String String} that represents the cipher text
     * encrypted by md5 algorithm.
     *
     * @param message - plain text as {@link String String}.
     * @return cipher text as {@link String String}.
     */
    // SOLID : vi phạm nguyên lý SRP vì class AuthenticationController thực hiện nhiều hơn 1 nhiệm vụ như vừa xác thực( login) vừa phải mã hóa  dữ liệu
    private String md5(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes(StandardCharsets.UTF_8));
            // converting byte array to Hexadecimal String
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Utils.getLogger(Utils.class.getName());
            digest = "";
        }
        return digest;
    }

}
