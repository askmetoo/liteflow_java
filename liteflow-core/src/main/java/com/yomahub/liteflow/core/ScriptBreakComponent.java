package com.yomahub.liteflow.core;

import com.yomahub.liteflow.script.ScriptExecuteWrap;
import com.yomahub.liteflow.script.ScriptExecutorFactory;

import java.util.Map;

/**
 * 脚本BREAK节点
 *
 * @author Bryan.Zhang
 * @since 2.9.0
 */
public class ScriptBreakComponent extends NodeBreakComponent implements ScriptComponent {

	@Override
	public boolean processBreak() throws Exception {
		ScriptExecuteWrap wrap = new ScriptExecuteWrap();
		wrap.setCurrChainId(this.getCurrChainId());
		wrap.setNodeId(this.getNodeId());
		wrap.setSlotIndex(this.getSlotIndex());
		wrap.setTag(this.getTag());
		wrap.setCmpData(this.getCmpData(Map.class));
		return (boolean) ScriptExecutorFactory.loadInstance()
			.getScriptExecutor(this.getRefNode().getLanguage())
			.execute(wrap);
	}

	@Override
	public void loadScript(String script, String language) {
		ScriptExecutorFactory.loadInstance().getScriptExecutor(language).load(getNodeId(), script);
	}

}
