package pl.com.sages.spring.io.lab03.cowsay;

import static java.lang.String.join;
import static java.util.Arrays.asList;
import static java.util.Collections.nCopies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cow {

    public static final List<String> cow = asList((
            "        \\   ^__^\n" +
            "         \\  (oo)\\_______\n" +
            "            (__)\\       )\\/\\\n" +
            "                ||----w |\n" +
            "                ||     ||\n")
            .split("\n"));

    @RequestMapping("/")
    public String sayHtml(@RequestParam(value = "msg", defaultValue = "Moo!") String text) {
        return  "<html>" +
                "<head><title>Cow Say...</title></head>" +
                "<body><pre>\n" +
                say(text) +
                "\n</pre></body>" +
                "</html>";
    }

    public String say(String text) {
        List<String> lines = asLines(text);
        lines.add(0, " " + join("", nCopies(40, "_")) + " ");
        lines.add(" " + join("", nCopies(40, "-")) + " ");
        lines.addAll(cow);
        return String.join("\n", lines);
    }

    private List<String> asLines(String text) {
        List<String> lines = new ArrayList<>();
        String reminder = text;
        do {
            if (reminder.length() > 38) {
                lines.add(asLine(reminder.substring(0, 38)));
                reminder = reminder.substring(38);
            } else {
                lines.add(asLine(reminder));
                reminder = null;
            }
        } while (reminder != null);
        return lines;
    }

    private String asLine(String text) {
        String filling = "";
        if (text.length() < 38) {
            filling = join("", nCopies(38 - text.length(), " "));
        }
        return "| " + text + filling + " |";
    }
}
