package model.data_structures;

public class EstacionDePolicia {
	
	
	private int objectID;
	private int epocod_plan;
	private int epoani_geo;
	
	private String epocod_ent; 
	private String epocod_proy; 
	private String epoest_proy;
	private String epointerv_esp;
	private String epodir_sitio;
	private String epocod_sitio;
	private String epoeasocia;
	private String epoidentif;
	
	private double epolatitud;
	private double epolongitud;
	private double epofecha_c;
	
	
	

	public EstacionDePolicia(int OBJECTID, int EPOCOD_PLAN, String EPOCOD_ENT, String EPOCOD_PROY, int EPOANIO_GEO, String EPOEST_PROY, String 
			EPOINTERV_ESP, String EPODIR_SITIO, String EPOCOD_SITIO, double EPOLATITUD, double EPOLONGITUD, String EPOEASOCIA, String EPOIDENTIF, double EPOFECHA_C)
	{
		
		objectID = OBJECTID;
		epocod_plan = EPOCOD_PLAN;
		epoani_geo = EPOANIO_GEO;
		
		epocod_ent = EPOCOD_ENT;
		epocod_proy = EPOCOD_PROY;
		epoest_proy = EPOEST_PROY;
		epointerv_esp = EPOINTERV_ESP;
		epodir_sitio = EPODIR_SITIO;
		epocod_sitio = EPOCOD_SITIO;
		epoeasocia = EPOEASOCIA;
		epoidentif = EPOIDENTIF;
		
		epolatitud = EPOLATITUD;
		epolongitud = EPOLONGITUD;
		epofecha_c = EPOFECHA_C;
	}




	public int getEpoani_geo() {
		return epoani_geo;
	}

	public int getObjectID() {
		return objectID;
	}

	public int getEpocod_plan() {
		return epocod_plan;
	}

	public String getEpocod_ent() {
		return epocod_ent;
	}

	public String getEpocod_proy() {
		return epocod_proy;
	}

	public String getEpoest_proy() {
		return epoest_proy;
	}

	public String getEpointerv_esp() {
		return epointerv_esp;
	}

	public String getEpodir_sitio() {
		return epodir_sitio;
	}

	public String getEpocod_sitio() {
		return epocod_sitio;
	}

	public String getEpoeasocia() {
		return epoeasocia;
	}

	public String getEpoidentif() {
		return epoidentif;
	}

	public double getEpolongitud() {
		return epolongitud;
	}

	public double getEpofecha_c() {
		return epofecha_c;
	}

	
}
