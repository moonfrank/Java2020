package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	
	public Login() {
		dp=new DataPersona();
	}
	
	public Persona validate(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
	}

	public LinkedList<Persona> getByApellido(Persona p)
	{
		return dp.getByApellido(p);
	}

	public void add(Persona p,int r)
	{
		dp.add(p,r);
	}

	public void edit(Persona p, int r)
	{
		dp.edit(p,r);
	}

	public void delete(Persona p)
	{
		dp.delete(p);
	}
}
