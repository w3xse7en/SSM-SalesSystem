import com.web.service.IsUser;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mew on 2017/7/1.
 */
public class TestIsUserImpl {
    @Autowired
    private static IsUser isUser;
    public static boolean test(){
        return isUser.isUser("buyer","123");
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}
