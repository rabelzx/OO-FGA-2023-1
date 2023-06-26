package trabalhoOO;

public class Evento {
	private String nomeEvento;
	private Data dtInicio;
	private Data dtFim;
	private Horario hrInicio;
	private Horario hrFim;

	public Evento () {}
	
	public Evento(String nomeEvento, Data dtInicio, Data dtFim, Horario hrInicio, Horario hrFim) {
		this.nomeEvento = nomeEvento;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
		this.hrInicio = hrInicio;
		this.hrFim = hrFim;
	}

	//setters e getters
	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Data getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Data dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Data getDtFim() {
		return dtFim;
	}

	public void setDtFim(Data dtFim) {
		this.dtFim = dtFim;
	}

	public Horario getHrInicio() {
		return hrInicio;
	}

	public void setHrInicio(Horario hrInicio) {
		this.hrInicio = hrInicio;
	}

	public Horario getHrFim() {
		return hrFim;
	}

	public void setHrFim(Horario hrFim) {
		this.hrFim = hrFim;
	}
}
