import com.web.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mew on 2017/7/1.
 */
public class TestIsUserImpl {
    @Autowired
    private static PersonDto personDto;

    public static boolean test() {
        return personDto.isUser("buyer", "123");
    }

    public static void main(String[] args) {
        int math = 51;
        for (int i = 0; i <= math / 2; i++) {
            System.out.println(i + "+" + (math - i) + "=" + math);
        }
    }
}
