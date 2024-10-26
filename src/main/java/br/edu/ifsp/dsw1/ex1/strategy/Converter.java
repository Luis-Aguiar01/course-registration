package br.edu.ifsp.dsw1.ex1.strategy;

public class Converter {
	private double temperature;
	private TemperatureConverter converter;
	
	public Converter() {
		temperature = 0.0;
		converter = new FahrenheitConverter();
	}
	
	public Converter(double temperature, TemperatureConverter converter) {
		setTemperature(temperature);
		setConverter(converter);
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public TemperatureConverter getConverter() {
		return converter;
	}

	public void setConverter(TemperatureConverter converter) {
		if (converter != null) {
			this.converter = converter;
		}
	}
	
	public double convert(double temperature) {
		return converter.convert(temperature);
	}
}
