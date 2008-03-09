package net.vasterling.scc;

import org.eclipse.core.runtime.IPlatformRunnable;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IPlatformRunnable {

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IPlatformRunnable#run(java.lang.Object)
	 */
	public Object run(Object args) throws Exception {
		Clientcon.main(null);
//		Display display = PlatformUI.createDisplay();
//		try {
//			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
//			if (returnCode == PlatformUI.RETURN_RESTART) {
//				return IPlatformRunnable.EXIT_RESTART;
//			}
//			return IPlatformRunnable.EXIT_OK;
//		} finally {
//			display.dispose();
//		}
		return IPlatformRunnable.EXIT_OK;
	}
}
