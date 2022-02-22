import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoadingController } from '@ionic/angular';
import { RestService } from 'src/app/services/rest.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  mail:any;
  pass:any;
  ofertas:any[];
  activo:any;

  constructor(private restService: RestService, private loadingCtrl: LoadingController, private route: Router) { }

  ngOnInit() {
    //this.showLoading();
  }

  check()
  {
    this.restService.login(this.mail,this.pass).subscribe( data => {
      console.log(data);

      if(data['activo'] === true && data['role'] === 'ROLE_ALUMNO')
      {
      this.route.navigate(['inicio']);
      console.log(data['activo']);
      }
      else
      console.log("Inactivo");
    
      });
  }

log()
{
  console.log(this.mail);
  console.log(this.pass);
  this.restService.login(this.mail,this.pass).subscribe( data => {
    console.log(data);
    this.restService.activo = data['activo']
    this.restService.token = data['token']

  });
}

async showLoading() {
  const loading = await this.loadingCtrl.create({
  message: 'Loading.....'
  });  
  loading.present();
  setTimeout(() => {
    loading.dismiss();
    this.check();
  }, 500 );
}

}
