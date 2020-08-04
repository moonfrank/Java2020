package ui;


import java.util.Scanner;

import entities.*;
import logic.Login;
import java.util.*;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "search":
			System.out.print(search());
			break;
		case "new":
			New();
			System.out.println("Persona registrada exitósamente!");
			break;
		case "edit":
			if(edit()) System.out.println("Datos de Persona actualizados exitósamente!");
			else System.out.println("Persona no existe");
			break;
		case "delete":
			if (delete()) System.out.println("Persona eliminada exitósamente!");
			else System.out.println("Persona no existe");
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}

	private LinkedList<Persona> search()
	{
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Apellido: ");
		p.setApellido(s.nextLine());

		return ctrlLogin.getByApellido(p);
	}

	private void New()
	{
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo Documento: ");
		d.setTipo(s.nextLine());
		System.out.print("Nro. Documento: ");
		d.setNro(s.nextLine());
		System.out.print("Nombre: ");
		p.setNombre(s.nextLine());
		System.out.print("Apellido: ");
		p.setApellido(s.nextLine());
		System.out.print("Email: ");
		p.setEmail(s.nextLine());
		System.out.print("Password: ");
		p.setPassword(s.nextLine());
		System.out.print("Teléfono: ");
		p.setTel(s.nextLine());
		System.out.print("Habilitado: ");
		p.setHabilitado(s.nextBoolean());
		System.out.print("Número rol: ");
		int r=(s.nextInt());
		ctrlLogin.add(p,r);
	}

	private boolean edit()
	{
		Persona p=find();
		if (p!=null)
		{
			Documento d=new Documento();
			p.setDocumento(d);
			System.out.print("Tipo Documento: ");
			d.setTipo(s.nextLine());
			System.out.print("Nro. Documento: ");
			d.setNro(s.nextLine());
			System.out.print("Nombre: ");
			p.setNombre(s.nextLine());
			System.out.print("Apellido: ");
			p.setApellido(s.nextLine());
			System.out.print("Email: ");
			p.setEmail(s.nextLine());
			System.out.print("Password: ");
			p.setPassword(s.nextLine());
			System.out.print("Teléfono: ");
			p.setTel(s.nextLine());
			System.out.print("Habilitado: ");
			p.setHabilitado(s.nextBoolean());
			System.out.print("Número rol: ");
			int r=(s.nextInt());
			ctrlLogin.edit(p,r);
			return true;
		}
		else return false;
	}

	private boolean delete()
	{
		Persona p=find();
		if (p!=null)
		{
			ctrlLogin.delete(p);
			return true;
		}
		else return false;
	}

}
