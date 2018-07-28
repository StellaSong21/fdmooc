package util;

public class MessageUtil {
    public static String decode(int code) {
        switch (code) {
            case 0x010100: // log ok
                return "Log in success!";
            case 0x010101: // wrong username
                return "Wrong username or password!";
            case 0x010102: // wrong password
                return "Wrong username or password!";
            case 0x010103:
                return "Log failed!";
            case 0x010104:
                return "Not logged!";
            case 0x010105:
                return "Logged!";
            case 0x010106:
                return "Logout success!";
            case 0x010107:
                return "Logout failed!";
            case 0x010201:
                return "User exist!";
            case 0x010202:
                return "Appending user failed!";
            case 0x010200:
                return "Appending user success!";
            case 0x010300:
                return "Mail sent!";
            case 0x010301:
                return "Mail failed!";
        }
        return "Unknown error!";
    }
}
