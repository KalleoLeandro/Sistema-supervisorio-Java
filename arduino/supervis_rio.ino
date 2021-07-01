void setup() 
{
  pinMode(8,OUTPUT);  
  pinMode(9,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(11,OUTPUT);
  
  pinMode(7,INPUT);
  pinMode(6,INPUT);
  pinMode(5,INPUT);
  pinMode(4,INPUT);
  Serial.begin(9600); 

}

void loop() 
{      
   if(Serial.available() > 0)
   {
     delay(100);
     char c = Serial.read();
     if(c == 'L')
     {
      digitalWrite(8,HIGH);
      digitalWrite(9,HIGH);
      digitalWrite(10,HIGH);
      digitalWrite(11,HIGH);    
     }
     if(c == 'D')
     {
      digitalWrite(8,LOW);
      digitalWrite(9,LOW);
      digitalWrite(10,LOW);
      digitalWrite(11,LOW);      
     }
   }      
   if(digitalRead(7) == 1)
    {
      Serial.println("1-Ligado");
    }
    else
    {
      Serial.println("1-Desligado");
    }
    if(digitalRead(6) == 1)
    {
      Serial.println("2-Ligado");      
    }
    else
    {
      Serial.println("2-Desligado");
    }
    if(digitalRead(5) == 1)
    {
      Serial.println("3-Ligado");
    }
    else
    {
      Serial.println("3-Desligado");
    }
    if(digitalRead(4) == 1)
    {
      Serial.println("4-Ligado");
    }
    else
    {
      Serial.println("4-Desligado");
    } 
}
