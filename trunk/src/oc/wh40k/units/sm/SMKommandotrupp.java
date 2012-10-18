package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMKommandotrupp extends Eintrag {

	OptionsEinzelUpgrade apo;
	OptionsEinzelUpgrade boss;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;
	RuestkammerStarter rkPrometheus;
        
        boolean siegeForce;

	public SMKommandotrupp() {
		name = "Kommandotrupp";
		grundkosten = 115;
		this.setEintragsCNT(0);

                siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);
                
		BuildaHQ.addToInformationVector("SMCommandSquad", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMKommandotrupp.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Space Marine Bikes", 90));

		seperator();

		add(apo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Apothecarius", 0));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kompaniestandarte", 15));
		add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kompaniechampion", "Kompaniechampion mit Energiewaffe und Parierschild", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

                if(!siegeForce) {
                
                    seperator();

                    rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
                    rkPod.initKammer(false);
                    rkPod.setButtonText("Landungskapsel");
                    rkPod.setSeperator(0);
                    add(rkPod);
                    
                } else {
                    
                    rkPrometheus = new RuestkammerStarter(ID, randAbstand, cnt, "SFLandRaiderPrometheusKammer", "Land Raider Prometheus");
                    rkPrometheus.initKammer();
                    rkPrometheus.setButtonText("Land Raider Prometheus");
                    add(rkPrometheus);
                }

		complete();
	}

	@Override
	public void refreshen() {
		apo.setSelected(true);
		
		int modi = boss.getSelectedAsInt();

		o1.setMaxAnzahl(8 - (modi * 2));
		o2.setMaxAnzahl(4 - modi);
		o3.setMaxAnzahl(4 - modi);
		o1.setButtonMaxAnzahl("Plasma-Pistole", 4 - modi);

                if(!siegeForce) {
                
                    rkTransport.setAktiv(!rkPod.isSelected());
                    rkPod.setAktiv(!rkTransport.isSelected());
                    
                } else {
                    
                    rkTransport.setAktiv(!rkPrometheus.isSelected());
                    rkPrometheus.setAktiv(!rkTransport.isSelected());
                }

		int selectedSquads = BuildaHQ.getCountFromInformationVector("SMCommandSquad");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("SMEnableCommandSquad");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Kommandotrupps > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("SMCommandSquad", -1);
		super.deleteYourself();
	}

}
