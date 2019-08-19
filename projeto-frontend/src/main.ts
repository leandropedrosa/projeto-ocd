import {enableProdMode} from '@angular/core';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {environmentLoader} from './environments/environmentLoader';
import {environment} from './environments/environment';
import {AppModule} from './app/app.module';


environmentLoader.then(env => {
  if (env.production) {
    enableProdMode();
  }

  environment.configuration = env.configuration;


  platformBrowserDynamic().bootstrapModule(AppModule).catch(e => console.error(e));
});
