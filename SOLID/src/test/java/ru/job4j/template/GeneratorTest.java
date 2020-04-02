package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {
    @Test
    public void whenTemplateIsEmptyThatSuccessProduce() {
        String template = "I am a Maxim, Who are programmers?";
        Map<String, String> args = new HashMap<>();
        Generator generator = new SimpleGeneration();
        String result = generator.produce(template, args);
        assertThat(result, is("I am a Maxim, Who are programmers?"));
    }

    @Test
    public void whenSuccessProduce() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        Generator generator = new SimpleGeneration();
        args.put("name", "Maxim");
        args.put("subject", "programmers");
        String result = generator.produce(template, args);
        assertThat(result, is("I am a Maxim, Who are programmers?"));
    }

    @Test(expected = Exception.class)
    public void whenKeysAreNotInMapThatThrowException() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        Generator generator = new SimpleGeneration();
        args.put("name", "Maxim");
        generator.produce(template, args);
    }

    @Test(expected = Exception.class)
    public void whenExtraKeysInMapThatThrowException() {
        String template = "I am a ${name}, Who are programmers?";
        Map<String, String> args = new HashMap<>();
        Generator generator = new SimpleGeneration();
        args.put("name", "Maxim");
        args.put("subject", "programmers");
        generator.produce(template, args);
    }
}
