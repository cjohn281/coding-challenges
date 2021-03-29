package hadoopMapReduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		// Convert the value to a String.
		String line = value.toString();
		
		// Split each line into a collection of words
		for (String word : line.split("\\W+")) {
			// if the length of the word is greater than 0, write it as the key of the mapper output with 1 as the value.
			if (word.length() > 0) {
				context.write(new Text(word), new IntWritable(1));
			}
		}
	}
}
