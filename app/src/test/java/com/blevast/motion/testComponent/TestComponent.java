package com.blevast.motion.testComponent;

import com.blevast.motion.di.component.AppComponent;
import com.blevast.motion.testmodule.NetModule;
import com.blevast.motion.testmodule.TrialModule;

import javax.inject.Singleton;

import dagger.Component;


//
//Code generation--> this will generate graphs for dependencies
//
@Singleton
@Component(modules = { NetModule.class, TrialModule.class } )
public interface TestComponent {


}
