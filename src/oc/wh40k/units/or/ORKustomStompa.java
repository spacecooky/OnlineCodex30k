package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORKustomStompa extends Eintrag {

	OptionsUpgradeGruppe Head;
	OptionsZaehlerGruppe RightArm;
	OptionsEinzelZaehler KrushaBall;
	OptionsEinzelZaehler LiftaDroppa;
	OptionsZaehlerGruppe Shoulder;
	OptionsEinzelZaehler BigGuns;
	OptionsUpgradeGruppe Hull;
	
	OptionsEinzelZaehler GrotBombLauncha;
	OptionsEinzelZaehler SupaRokkits;
	OptionsEinzelZaehler GrotSponsons;
	OptionsEinzelUpgrade DeffArsenal;
	
	OptionsEinzelUpgrade RPJ;
	OptionsEinzelUpgrade Supercharger;
	OptionsEinzelUpgrade RepairKrew;
	OptionsEinzelUpgrade Powerfield;
	
	public ORKustomStompa() {

		name = "Kustom Stompa";
		grundkosten = 350;

		add(ico = new oc.Picture("oc/wh40k/images/KustomStompa.gif"));


		ogE.addElement(new OptionsGruppeEintrag("Big Shoota","Head: Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Flamebelcha","Head: Flamebelcha", 30));
		ogE.addElement(new OptionsGruppeEintrag("Gaze of Mork","Head: Gaze of Mork", 50));
		Head = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(Head);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Deth Kannon","Arm: Deth Kannon", 100));
		ogE.addElement(new OptionsGruppeEintrag("Deth K./Supa-gatler","Arm: Deth Kannon with co-axial supa-gatler", 150));
		ogE.addElement(new OptionsGruppeEintrag("Deth K./Giga-shoota","Arm: Deth Kannon with co-axial giga-shoota", 150));
		ogE.addElement(new OptionsGruppeEintrag("Giga Shoota","Arm: Giga Shoota", 75));
		ogE.addElement(new OptionsGruppeEintrag("Bursta Gun","Arm: Bursta Gun", 75));
		ogE.addElement(new OptionsGruppeEintrag("Skullhamma Kannon","Arm: Skullhamma Kannon", 100));
		ogE.addElement(new OptionsGruppeEintrag("Titan CCW","Arm: Titan close combat weapon", 25));
		RightArm = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,2);
		add(RightArm);
		add(KrushaBall = new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Krusha Ball","Arm: Krusha Ball",1,50));
		add(LiftaDroppa = new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Lifta Droppa","Arm: Lifta Droppa",1,25));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big Shoota","Shoulder: Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha","Shoulder: Skorcha", 5));
		ogE.addElement(new OptionsGruppeEintrag("TL Big Shoota","Shoulder: twin-linked Big Shoota", 10));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha","Shoulder: Rokkit Launcha", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta","Shoulder: Kustom Mega Blasta", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lobba","Shoulder: Lobba", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kannon","Shoulder: Kannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Zzap Gun","Shoulder: Zza Gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Supa-Skorcha","Shoulder: Supa-Skorcha", 20));
		ogE.addElement(new OptionsGruppeEintrag("Deffgun","Shoulder: Deffgun", 25));
		Shoulder = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,2);
		add(Shoulder);
		
		seperator();
		
		add(BigGuns = new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Big Shootas","Hull: Big Shootas",5,5));
		ogE.addElement(new OptionsGruppeEintrag("Kannon","Hull: Kannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Supa Lobba","Hull: Supa Lobba", 20));
		ogE.addElement(new OptionsGruppeEintrag("Flamebelcha","Hull: Flamebelcha", 30));
		ogE.addElement(new OptionsGruppeEintrag("Big Zzappa","Hull: Big Zzappa", 30));
		ogE.addElement(new OptionsGruppeEintrag("Killkannon","Hull: Killkannon", 60));
		ogE.addElement(new OptionsGruppeEintrag("Gigashoota","Hull: GigaShoota", 75));
		ogE.addElement(new OptionsGruppeEintrag("Belly Gun","Hull: Belly Gun", 150));
		Hull = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(Hull);
		
		seperator();
		
		add(GrotBombLauncha = new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Grot Bomb Launcha",2,10));
		add(SupaRokkits = new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Supa Rokkit",3,20));
		add(GrotSponsons = new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Grot Sponson",4,10));
		add(DeffArsenal = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Deff Arsenal",120));
		
		seperator();
		
		add(RPJ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Red Paint Job",25));
		add(Supercharger = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Supercharger",25));
		add(RepairKrew = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Repair Krew",75));
		add(Powerfield = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Powerfield",60));
		
		
		complete();



	}

	//@OVERRIDE
	public void refreshen() {
		RightArm.setMaxAnzahl(2-KrushaBall.getAnzahl()-LiftaDroppa.getAnzahl());
		KrushaBall.setAktiv((RightArm.getAnzahl()+LiftaDroppa.getAnzahl())<2);
		LiftaDroppa.setAktiv((RightArm.getAnzahl()+KrushaBall.getAnzahl())<2);
		RightArm.setLegal((RightArm.getAnzahl()+KrushaBall.getAnzahl()+LiftaDroppa.getAnzahl())==2);
		KrushaBall.setLegal((RightArm.getAnzahl()+KrushaBall.getAnzahl()+LiftaDroppa.getAnzahl())==2);
		LiftaDroppa.setLegal((RightArm.getAnzahl()+KrushaBall.getAnzahl()+LiftaDroppa.getAnzahl())==2);
		
		BigGuns.setAktiv(!Hull.isSelected());
		Hull.setAktiv(!BigGuns.isSelected());
		
		DeffArsenal.setAktiv(!GrotBombLauncha.isSelected() && !SupaRokkits.isSelected() && !GrotSponsons.isSelected());
		GrotBombLauncha.setAktiv(!DeffArsenal.isSelected());
		SupaRokkits.setAktiv(!DeffArsenal.isSelected());
		GrotSponsons.setAktiv(!DeffArsenal.isSelected());
		
		Supercharger.setAktiv(RightArm.getAnzahl(6)==2);
	}
}
