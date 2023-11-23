package hello.thymeleaf.basic;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("modelData", "반갑습니다");
        return "basic/text-basic";
    }

    @GetMapping("/text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("modelData", "Hello <b>Spring!!</b>");
        return "basic/text-unescaped";
    }

   /* @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "basic/variable";
    }*/

    @GetMapping("/basic-objects")
    public String basicObjects(HttpSession session) {
        session.setAttribute("sessionData", "Hello Session!!");
        return "basic/basic-objects";
    }

    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            return "Hello" + data;
        }
    }

    @GetMapping("date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }

    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "penguin");
        model.addAttribute("param2", "12345");
        return "basic/link";
    }

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "반가워요");
        return "basic/literal";
    }

    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "데이터 있음!!");
        return "basic/operation";
    }

    @GetMapping("/attribute")
    public String attribute() {
        return "basic/attribute";
    }

    @GetMapping("/each")
    public String each(Model model) {
        addUsers(model);
        return "basic/each";
    }

    @GetMapping("/condition")
    public String condition(Model model) {
        addUsers(model);
        return "basic/condition";
    }

    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("data", "Spring!!");
        return "basic/comments";
    }

    @GetMapping("/block")
    public String block(Model model) {
        addUsers(model);
        return "basic/block";
    }

    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", new User("userA", 10));
        addUsers(model);
        return "basic/javascript";
    }

    private void addUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User("UserA", 10));
        list.add(new User("UserB", 20));
        list.add(new User("UserC", 30));

        model.addAttribute("users", list);
    }

    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    @Data
    static class Penguin {
        private String name;
        private int weight;

        public Penguin(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    @GetMapping("/variable")
    public String variable(Model model) {
        Penguin gentoo = new Penguin("젠투 펭귄", 10);
        Penguin emperor = new Penguin("황제 펭귄", 20);
        Penguin galapagos = new Penguin("갈라파고스 펭귄", 30);

        List<Penguin> penguins = new ArrayList<>();
        penguins.add(gentoo);
        penguins.add(emperor);
        penguins.add(galapagos);

        Map<String, Penguin> map = new HashMap<>();
        map.put("젠투 펭귄", gentoo);
        map.put("황제 펭귄", emperor);
        map.put("갈라파고스 펭귄", galapagos);

        model.addAttribute("penguin", gentoo);
        model.addAttribute("penguins", penguins);
        model.addAttribute("penguinMap", map);

        return "basic/variable";
    }

}
