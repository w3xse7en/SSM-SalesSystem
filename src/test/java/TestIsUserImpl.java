import com.web.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mew on 2017/7/1.
 */
public class TestIsUserImpl {
    @Autowired
    private static PersonDto personDto;
    public static boolean test(){
        return personDto.isUser("buyer","123");
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}
