import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent {


    StudentArray: any[]=[];

    studentname:String="";
    studentaddress:String="";
    mobile:Number=0;

    currentStudentID="";

    constructor(private _http:HttpClient){
      
       // this.getAllCustomer();
    }


    register(){

        let bodyData={
          "studentname":this.studentname,
          "studentaddress":this.studentaddress,
          "mobile":this.mobile

        };

        this._http.post("http://localhost:8081/api/v1/student/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Student Registered Successfully");
        this.getAllStudent();
        this.studentname = '';
        this.studentaddress = '';
        this.mobile  = 0;
    });

          }
          getAllStudent()
          {
            
            this._http.get("http://localhost:8081/api/v1/student/getall")
          
            .subscribe((resultData: any)=>
            {
            
                console.log(resultData);
                this.StudentArray = resultData;
            });
          }


}
