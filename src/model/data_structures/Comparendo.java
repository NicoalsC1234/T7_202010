package model.data_structures;

import java.util.Date;

public class Comparendo implements Comparable<Comparendo>
{
	private int objectId;
	private Date fecha_hora;
	private String des_infrac;
	private String medio_dete;
	private String clase_vehi;
	private String tipo_servi;
	private String infraccion;
	private String localidad;

	private double latitud;
	private double longitud;
	private int comparador;

	public Comparendo(int objeId, Date fecha, String descripcion, String detencion, String claseVeh, String tipoSer, String codInfraccion, String localidadP, double lonP, double latP)
	{
		objectId = objeId;
		fecha_hora = fecha;
		des_infrac = descripcion;
		medio_dete = detencion;
		clase_vehi = claseVeh;
		tipo_servi = tipoSer;
		infraccion = codInfraccion;
		localidad = localidadP;
		longitud = lonP;
		latitud = latP;
		comparador = 0;

	}
	public String darDatos()
	{
		return "\nOBJECTID: " + objectId + "\nFECHA_HORA: " + fecha_hora.toString() + "\nINFRACCION: " + infraccion + "\nCLASE_VEHI: "+ clase_vehi +"\nTIPO_SERVI: " + tipo_servi + "\nLOCALIDAD: " + localidad;
	}

	@Override
	public int compareTo(Comparendo pComparendo) 
	{		
		
		if(comparador == 1)
		{
			if(localidad.equals(pComparendo.darLocalidad())) 
			{
				return 0;
			}
			else 
				return localidad.compareTo(pComparendo.darLocalidad());
		}
		
		else if(comparador == 2)
		{
			Haversine c = new Haversine();
			if(c.distance(4.647586, -74.078122, latitud, longitud) < c.distance(4.647586, -74.078122, pComparendo.darLatitud(), pComparendo.darLongitud()) )
			{
				return 1;
			}
			else if(c.distance(4.647586, -74.078122, latitud, longitud) > c.distance(4.647586, -74.078122, pComparendo.darLatitud(), pComparendo.darLongitud()) )
			{
				return -1;
			}
			
			else return 0;	
			
		}
		
		else return 0;
		
		
	}
	
	public void cambiarComparador(int x)
	{
		comparador = x;
	}

	public int darId()
	{
		return  objectId;
	}

	public Date darFechaHora()
	{
		return fecha_hora;
	}

	public String darClase()
	{
		return clase_vehi;
	}

	public String darTipo()
	{
		return tipo_servi;
	}

	public String darInfraccion()
	{
		return infraccion;
	}

	public String darDescInfra()
	{
		return des_infrac;
	}

	public String darLocalidad()
	{
		return localidad;
	}

	public String darMedioDete()
	{
		return medio_dete;
	}

	public double darLongitud()
	{
		return longitud;
	}

	public double darLatitud()
	{
		return latitud;
	}

	public boolean parametroFecha(Date pFecha)
	{
		return fecha_hora.getMonth() == pFecha.getMonth() && fecha_hora.getDate() == pFecha.getDate();
	}

	public boolean parametroInfraccion(String pInfraccion) 
	{
		return infraccion.equals(pInfraccion);
	}

	public boolean parametroLocalidad(String pLocalidad)
	{
		return localidad.equals(pLocalidad);
	}

	public boolean parametroTipo(String pTipo) 
	{
		return tipo_servi.equals(pTipo);
	}
}