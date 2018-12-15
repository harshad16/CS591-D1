package src.entities;

import java.util.Arrays;

public class Calculations {
    Double[] data;
    int size;   

    public Calculations(Double[] assign_wise) {
        this.data = assign_wise;
        size = assign_wise.length;
    }   

    public double getMean() {
        double sum = 0.0;
        for(double a : data)
            sum += a;
        return sum/size;
    }

    public double getVariance() {
        double mean = getMean();
        double temp = 0;
        for(double a :data)
            temp += (a-mean)*(a-mean);
        return temp/(size-1);
    }
    
    public double getMax() {
    	Arrays.sort(data);
    	return data[size-1];
    }
    
    public double getMin() {
    	Arrays.sort(data);
    	return data[0];
    }

    public double getStdDev() {
        return Math.sqrt(getVariance());
    }

    public double median() {
    	try {
	       Arrays.sort(data);
	       if (data.length % 2 == 0)
	          return (data[(data.length / 2) - 1] + data[data.length / 2]) / 2.0;
	       return data[data.length / 2];
    	}catch (Exception e) {
			// TODO: handle exception
    		return 0.0;
		}
    }
}
