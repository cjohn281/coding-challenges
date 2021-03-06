package hadoopMapReduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		// initialize a counter to 0.
		int count = 0;
		
		// for each IntWritable in values, add to the counter
		for (IntWritable value : values) {
			count += value.get();
		}
		
		// write Reducer output
		context.write(key, new IntWritable(count));
	}
}
