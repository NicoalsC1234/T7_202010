package model.data_structures;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comparendo implements Comparable<Comparendo> {

	public int OBJECTID;

	public SimpleDateFormat FECHA_HORA;

	public String MEDIO_DETE;

	public String CLASE_VEHI;

	public String TIPO_SERVI;

	public String INFRACCION;

	public String DES_INFRAC;

	public String LOCALIDAD;

	public double longitud;

	public double latitud;

	@Override
	public int compareTo(Comparendo comparendo) {

		if(OBJECTID - comparendo.OBJECTID > 0) return 123456;
		else if(OBJECTID - comparendo.OBJECTID < 0) return -1456789;
		else return 0;
	}

	public int hashCode()
	{
		int hash = 17;
		hash = 31 * hash + FECHA_HORA.hashCode();
		hash = 31 * hash + CLASE_VEHI.hashCode();
		hash = 31* hash + INFRACCION.hashCode();
		return hash;
	}

	@Override
	public String toString()
	{
		return "Los datos del comparendo son " + OBJECTID +", " + FECHA_HORA + ", " + INFRACCION + ", " + CLASE_VEHI  + ", " +  TIPO_SERVI  + ", " + LOCALIDAD;			
	}

}