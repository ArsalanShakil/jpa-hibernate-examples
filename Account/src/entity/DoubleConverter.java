package entity;
import javax.persistence.*;

public class DoubleConverter  implements AttributeConverter<Double,Integer>{
	int count = 0;
	@Override
	public Integer convertToDatabaseColumn(Double attribute) {
	     String str = Double.toString(attribute);
	     String[] convert = str.split("\\.");
	     int start = Integer.parseInt(convert[0]);
	     int end = Integer.parseInt(convert[1]);
	     count = String.valueOf(end).length();
	     String convertedStr= Integer.toString(start)+Integer.toString(end);
	     int converted = Integer.parseInt(convertedStr);
		return converted;
	}

	@Override
	public Double convertToEntityAttribute(Integer dbData) {
	     int base = 10, exponent = count ;
	     long result = 1;
	     for (; exponent != 0; --exponent) {
	       result *= base;
	     }
	     Double d2=Double.valueOf(dbData);
		return d2/result;
	}

}
