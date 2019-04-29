package com.pvkr.java8.domain;

import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@EqualsAndHashCode(callSuper = false)
public class MacbookPro extends Computer {

	private String color;
	private Integer year;
	private Double price;

	public MacbookPro(String color) {
		this.color = color;
	}

	public MacbookPro(String color, Integer year) {
		this.color = color;
		this.year = year;
	}

	@Override
	public Double calculateValue(Double initialValue) {
		Function<Double, Double> function = super::calculateValue;
		Double pcValue = function.apply(initialValue);
		return pcValue + (initialValue / 10);
	}
}
