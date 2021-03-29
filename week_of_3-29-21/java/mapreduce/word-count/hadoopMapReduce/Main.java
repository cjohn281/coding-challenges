package hadoopMapReduce;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		// Config stuff
		Job job = Job.getInstance();
		job.setJarByClass(Main.class);
		job.setJobName("Word Count");
		
		FileInputFormat.setInputPaths(job, new Path("input"));
		FileOutputFormat.setOutputPath(job, new Path("output"));
		
		job.setMapperClass(WordMapper.class);
		job.setReducerClass(SumReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		boolean success = job.waitForCompletion(true);
		
		System.exit(success ? 0 : 1);
	}

}
