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
/** 
 * Procedual Cohesion vì các phương thức đều liên quan đến việc xác thực người dùng 
 * và đăng nhập đăng xuất nên nằm trong cùng một lớp theo 1 trình tự nhất định
*/
/* SRP
* Lớp này tồn tại nhiều hơn 1 lý do để thay đổi. Nhiệm vụ chính là xác thực đăng nhập
* nhưng lại chứa phương thức mã hóa mật khẩu md5(), cần tách thành các lớp riêng biệt.
*/
public class AuthenticationController extends BaseController {
    private SessionInformation sessionInformation = SessionInformation.getInstance();
    public boolean isAnonymousSession() {
        try {
            getMainUser();
            return false;
        } catch (Exception ex) {
            return true;
        }
    }

    public User getMainUser() throws ExpiredSessionException {
        if (sessionInformation.getMainUser() == null || sessionInformation.getExpiredTime() == null || sessionInformation.getExpiredTime().isBefore(LocalDateTime.now())) {
            logout();
            throw new ExpiredSessionException();
        } else return sessionInformation.getMainUser().cloneInformation();
    }

    public void login(String email, String password) throws Exception {
        try {
            User user = new UserDAO().authenticate(email, md5(password));
            if (Objects.isNull(user)) throw new FailLoginException();
            sessionInformation.setMainUser(user);
            sessionInformation.setExpiredTime(LocalDateTime.now().plusHours(24)) ;
        } catch (SQLException ex) {
            throw new FailLoginException();
        }
    }

    public void logout() {
        sessionInformation.setExpiredTime(null);
        sessionInformation.setMainUser(null);
    }

    /**
     * Return a {@link String String} that represents the cipher text
     * encrypted by md5 algorithm.
     *
     * @param message - plain text as {@link String String}.
     * @return cipher text as {@link String String}.
     */
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
