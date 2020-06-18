package core2.streams;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 下游收集器
 */
public class DownstreamCollectors {

    @Getter
    public static class City {

        private String name;
        private String state;
        private Integer population;

        public City(String name, String state, Integer population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }
    }

    public static Stream<City> readCities(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).map(l -> l.split(",")).map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }

    public static void main(String[] args) throws IOException {

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        locales = Stream.of(Locale.getAvailableLocales());

        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
        // System.out.println(countryToLocaleSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
        // System.out.println(countryToLocaleCounts);

        Stream<City> cities = readCities("F://cities.txt");
        Map<String, Integer> stateToPopulation = cities.collect(Collectors.groupingBy(
                City::getName, Collectors.summingInt(City::getPopulation)
        ));
        // System.out.println(stateToPopulation);

        cities = readCities("F://cities.txt");
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(
                Collectors.groupingBy(City::getState,
                        Collectors.mapping(
                                City::getName,
                                Collectors.maxBy(Comparator.comparing(String::length))
                        )
                )
        );
        // System.out.println(stateToLongestCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguages = locales.collect(Collectors.groupingBy(
                Locale::getDisplayCountry,Collectors.mapping(Locale::getDisplayLanguage,Collectors.toSet()))
        );
        // System.out.println(countryToLanguages);

        cities = readCities("F://cities.txt");
        Map<String,IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(Collectors.groupingBy(City::getState,Collectors.summarizingInt(City::getPopulation)));
        // System.out.println(stateToCityPopulationSummary);

        cities = readCities("F://cities.txt");
        Map<String, String> stateToCityNames = cities.collect(Collectors.groupingBy(
                    City::getState,
                    Collectors.reducing("",City::getName,(s,t) -> s.length() == 0 ? t : s + " , " + t )
                ));
        // System.out.println(stateToCityNames);

        cities = readCities("F://cities.txt");
        stateToCityNames = cities.collect(Collectors.groupingBy(City::getState,Collectors.mapping(City::getName,Collectors.joining(", "))));
        System.out.println(stateToCityNames);


    }

}
