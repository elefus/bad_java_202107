package com.bad_java.lectures._12;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class ParseStringTest {

	/**
	 * Выбирает из текста наиболее часто встречающиеся слова.
	 * Подсчет слов выполняется без учета их регистра, т.е. "Привет", "привет", "пРиВеТ" - одно и то же слово.
	 * Если некоторые слова имеют одинаковую частоту, то в выходном списке они упорядочиваются в лексикографическом порядке.
	 *
	 * @param text        Исходный текст в котором слова (в смешанном регистре) разделены пробелами.
	 * @param numberWords Количество наиболее часто встречающихся слов, которые необходимо отобрать.
	 * @return Список отобранных слов (в нижнем регистре).
	 */
	private List<String> getFrequentlyOccurringWords(String text, int numberWords) {


		return Pattern.compile("[\\s,]+")
				.splitAsStream(text)
				.map(String::toLowerCase)
				.collect(groupingBy(identity(), counting()))
				.entrySet()
				.stream()
				.sorted(Entry.<String, Long>comparingByValue().reversed()
						.thenComparing(comparingByKey()))
				.limit(numberWords)
				.map(Entry::getKey)
				.collect(toList());
	}

	@Test
	void test2() {
		String source = "Lorem  ipsum dolor sit,    amet consectetur adipiscing elit Sed sodales consectetur purus at "
				+ "faucibus Donec mi quam tempor vel ipsum non faucibus suscipit massa Morbi lacinia velit "
				+ "blandit tincidunt efficitur Vestibulum. eget metus imperdiet sapien laoreet faucibus Nunc "
				+ "eget vehicula mauris ac auctor lorem Lorem ipsum dolor sit amet consectetur adipiscing elit "
				+ "Integer vel odio nec mi tempor dignissim";

		List<String> result = getFrequentlyOccurringWords(source, 10);
		assertThat(result).containsExactly("consectetur",
				"faucibus", "ipsum", "lorem", "adipiscing", "amet", "dolor", "eget", "elit", "mi");
	}
}
