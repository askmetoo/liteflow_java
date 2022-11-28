package com.yomahub.liteflow.test;

import com.yomahub.liteflow.core.FlowInitHook;
import com.yomahub.liteflow.flow.FlowBus;
import com.yomahub.liteflow.property.LiteflowConfigGetter;
import com.yomahub.liteflow.spi.holder.SpiFactoryCleaner;
import com.yomahub.liteflow.spring.ComponentScanner;
import com.yomahub.liteflow.thread.ExecutorHelper;
import org.junit.AfterClass;

/**
 * @author tangkc
 * @since 2.8.6
 */
public class BaseTest   {
	@AfterClass
	public static void cleanScanCache(){
		ComponentScanner.cleanCache();
		FlowBus.cleanCache();
		ExecutorHelper.loadInstance().clearExecutorServiceMap();
		SpiFactoryCleaner.clean();
		LiteflowConfigGetter.clean();
		FlowInitHook.cleanHook();
	}
}
