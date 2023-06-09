import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  
  onButton1Click(): void {
    console.log("Button 1 clicked");
    // ajoutez ici le code à exécuter lorsque le bouton 1 est cliqué
  }

  onButton2Click(): void {
    console.log("Button 2 clicked");
    // ajoutez ici le code à exécuter lorsque le bouton 2 est cliqué
  }

}
