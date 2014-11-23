package pl.com.sages.spring.io.lab03.cowsay.chuck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChuckResponse {

    private ChuckJoke value;

    public ChuckJoke getValue() {
        return value;
    }

    public void setValue(ChuckJoke value) {
        this.value = value;
    }
}
