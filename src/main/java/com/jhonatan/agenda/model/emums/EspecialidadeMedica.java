package com.jhonatan.agenda.model.emums;

public enum EspecialidadeMedica {
	ANATOMIA_PATOLOGICA(1, "Anatomia Patológica"),
	ANESTEOLOGIA(2, "Anestesiologia"),
	ANGIOLOGIA_E_CIRURGIA_VASCULAR(3, "Angiologia e Cirurgia Vascular"),
	CARDIOLOGIA(4, "Cardiologia"),
	CARDIOLOGIA_PEDIATRICA(5, "Cardiologia Pediátrica"),
	CIRURGIA_CARDIACA(6, "Cirurgia Cardíaca"),
	CIRURGIA_CARDIOTORACICA(7, "Cirurgia Cardiotorácica"),
	CIRURGIA_GERAL(8, "Cirurgia Geral"),
	CIRURGIA_MAXILOFACIAL(9, "Cirurgia Maxilofacial"),
	CIRURGIA_PEDIATRICA(10, "Cirurgia Pediátrica"),
	CIRURGIA_PLASTICA_RECONSTRUTIVA_ESTETICA(11, "Cirurgia Plástica Reconstrutiva e Estética"),
	CIRURGIA_TORACICA(12, "Cirurgia Torácica"),
 	DERMATOVENOREOLOGIA(13,"Dermatovenereologia"),
	DOENCAS_INFECCIOSAS(14,"Doenças Infecciosas"),
	ENDOCRINOLOGIA_E_NUTRICAO(15,"Endocrinologia e Nutrição"),
	ESTOMATOLOGIA(16,"Estomatologia"),
	GASTRENTEROLOGIA(17,"Gastrenterologia"),
	GENETICA_MEDICA(18,"Genética Médica"),
	GINECOLOGIA_OBSTETRICIA(19,"Ginecologia/Obstetrícia"),
	IMUNOALERGOLOGIA(20,"Imunoalergologia"),
//	(21,"Imuno-hemoterapia"),
//	(22,"Farmacologia Clínica"),
//	(23,"Hematologia Clínica"),
//	(24,"Medicina Desportiva"),
//	(25,"Medicina do Trabalho"),
//	(26,"Medicina Física e Reabilitação"),
//	(27,"Medicina Geral e Familiar"),
//	(28,"Medicina Intensiva"),
//	(29,"Medicina Interna"),
//	(30,"Medicina Legal"),
//	(31,"Medicina Nuclear"),
//	(32,"Medicina Tropical"),
	NEFROLOGIA(33,"Nefrologia"),
//	(34,"Neurocirurgia"),
	NEUROLOGIA(35,"Neurologia"),
//	(36,"Neurorradiologia"),
	OFTALMOLOGIA(37,"Oftalmologia"),
//	(38,"Oncologia Médica"),
	ORTOPEDIA(39,"Ortopedia"),
//	(40,"Otorrinolaringologia"),
//	(41,"Patologia Clínica"),
	PEDIATRIA(42,"Pediatria"),
//	(43,"Pneumologia"),
//	(44,"Psiquiatria"),
//	(45,"Psiquiatria da Infância e da Adolescência"),
	RADIOLOGIA(46,"Radiologia");
//	(47,"Radioncologia"),
//	(48,"Reumatologia"),
//	(49,"Saúde Pública"),
//	(50,"Urologia")
	
	private int codigo;
	private String descricao;

	private EspecialidadeMedica(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EspecialidadeMedica toEnum(int codigo) {
		for(EspecialidadeMedica em : EspecialidadeMedica.values()) {
			if(em.getCodigo() == codigo) {
				return em;
			}
		}
		throw new IllegalArgumentException("ID: "+ codigo +" invalido para Especialidade Medica");
	}
}
