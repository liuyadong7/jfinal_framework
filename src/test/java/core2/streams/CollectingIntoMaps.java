package core2.streams;

import lombok.Data;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 收集映射表
 */
public class CollectingIntoMaps {

    /**
     * 人的类
     */
    @Data
    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "李白"), new Person(1002, "杜甫"), new Person(1003, "李清照"));
    }

    public static void main(String[] args) throws IOException {

        Map<Integer, String> idToName = people().collect(Collectors.toMap(Person::getId, Person::getName));
        // System.out.println(idToName);

        Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        // System.out.println(idToPerson);

        idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity(), (existingValue, newValue) -> {
            throw new IllegalStateException();
        }, TreeMap::new));
        // System.out.println(idToPerson);

        // 获取java环境下安装的本地话语言
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(Collectors.toMap(
                Locale::getDisplayLanguage,
                l -> l.getDisplayLanguage(l),
                (existingValue, newValue) -> newValue)
        );
        // System.out.println(languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> {
                            Set<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                        }
                )
        );
        // System.out.println(countryLanguageSets);

        locales = Stream.of(Locale.getAvailableLocales());
        // 国家群进行分组
        Map<String,List<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getDisplayCountry));
        System.out.println(countryToLocales);
    }

}
