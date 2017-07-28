package java8ex;

@FunctionalInterface
public interface RunnableEx {
	void run() throws Exception;

	// 1.6
	static Runnable uncheck(RunnableEx runner) {
		return new Runnable() {
			public void run() {
				try {
					runner.run();
				} catch (Exception e) {
					throw new RuntimeException();
				}
			}
		};
	}
}
//cannot pass Callable<Void> instead of RunnableEx; it could be possible if in the end of func in run : return null;