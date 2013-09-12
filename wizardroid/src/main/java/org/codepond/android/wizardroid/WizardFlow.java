package org.codepond.android.wizardroid;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * WizardFlow holds information regarding the wizard's steps and flow.
 * Use {@link WizardFlow.Builder} to create an instance of WizardFlow.
 */
public class WizardFlow {
	private final List<Class<? extends WizardStep>> steps;

	private WizardFlow(List<Class<? extends WizardStep>> steps) {
		this.steps = steps;
	}

	/**
	 * Get the steps from the wizard's flow.
	 * @return {@link WizardStep} List of WizardStep.
	 */
	public List<Class<? extends WizardStep>> getSteps() {
		return steps;
	}

	/**
	 * Builder for {@link WizardFlow}. Use this class to build an instance of WizardFlow and 
	 * eventually call {@link WizardFlow.Builder#create()} to create the instance.
	 */
	public static class Builder {

		private List<Class<? extends WizardStep>> wizardSteps;

        /**
		 * Construct a WizardFlow.Builder
		 */
		public Builder() {
			wizardSteps = new ArrayList<Class<? extends WizardStep>>();
		}
		
		/**
		 * Add a step to the WizardFlow. Note that the wizard flow is determined by the order of added steps.
		 * @param stepClass
		 *            The class of {@link WizardStep} to create (if necessary)
		 * @return Builder for chaining set methods
		 */
		public Builder addStep(Class<? extends WizardStep> stepClass) {
			wizardSteps.add(stepClass);
			return this;
		}
		
		/**
		 * Create a new {@link WizardFlow} object.
		 * @return WizardFlow Instance of WizardFlow
		 */
		public WizardFlow create() {
			if (wizardSteps.size() > 0) {
				return new WizardFlow(wizardSteps);
			}
			else {
				throw new RuntimeException("Cannot create WizardFlow. No step has been added! Call Builder#addStep(stepClass) to add steps to the wizard flow.");
			}
		}
	}
}