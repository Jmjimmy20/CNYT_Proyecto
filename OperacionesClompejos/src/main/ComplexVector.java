package main;

import java.util.ArrayList;
import java.util.List;

public class ComplexVector {
	
	List<Complejo> ListVector = new ArrayList<Complejo>();
	int size;
	
	public ComplexVector(int SizeN) {
		size = SizeN;
	}
	
	public void AddValue(Complejo CompNew){
        if(size > ListVector.size()){
            ListVector.add(CompNew);
        } 
    }
	
	public int GetSize(){
        return size;
    }
	
	public Complejo GetPosition(int pos){
        return ListVector.get(pos);
    }
	

	public ComplexVector Inverso(){
        ComplexVector listaN = new ComplexVector(size);
        for(int i = 0; i < size; i++){
            Complejo complejoRespaldo;
            complejoRespaldo = ListVector.get(i);
            double realN = (complejoRespaldo.real * -1);
            double imaginarioN = (complejoRespaldo.imag* -1);
            complejoRespaldo = new Complejo(realN, imaginarioN);
            listaN.AddValue(complejoRespaldo);
        }
        return listaN;
    }
	
	public ComplexVector Conjugado(){
        ComplexVector retorno = new ComplexVector(size);
        for (Complejo c : ListVector){
            retorno.AddValue(c.Conjugado());
                      
        }
        return retorno;
    }
	
	public void Print(){
        for(int i = 0; i < size; i++){
            System.out.println(this.GetPosition(i).real + " " +this.GetPosition(i).imag);
        }
            System.out.println("");
    }
	
}
