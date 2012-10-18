package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class ORBosse extends Eintrag {

	AnzahlPanel Bosse;
	OptionsEinzelUpgrade Bossbikaz;
	OptionsEinzelUpgrade Stikkbombz;
	OptionsZaehlerGruppe BosseCC;
	OptionsZaehlerGruppe BosseFK;
	OptionsEinzelZaehler Panzarüstung;
	OptionsEinzelZaehler Trophäenstange;
	OptionsEinzelZaehler Waaaghbanner;
	OptionsEinzelZaehler Munigrotz;
	OptionsEinzelUpgrade Dok;
	OptionsEinzelUpgrade Grotassistänt;
	OptionsEinzelUpgrade CybOrkKörpa;
	RuestkammerStarter PikkUp;
	RuestkammerStarter Kampfpanza;
	boolean spezialAuswahl = false;
	OptionsEinzelUpgrade madDokCybork;

	public ORBosse() {
		kategorie = 2;
		grundkosten = 0;

		Bosse = new AnzahlPanel(ID, randAbstand, cnt, "Bosse", 3, 10, 20);
		add(Bosse);

		add(ico = new oc.Picture("oc/wh40k/images/Bosse.gif"));
		

		seperator();

		add(Bossbikaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bossbikaz", 25, Bosse.getModelle()));
		add(Stikkbombz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombz", 1, Bosse.getModelle()));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Fette Spalta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiekrallä", 25));
		BosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(BosseCC);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bazzukka-Kombi", 5));
		ogE.addElement(new OptionsGruppeEintrag("Gitbrenna-Kombi", 5));
		ogE.addElement(new OptionsGruppeEintrag("sync. Wumme", 5));
		BosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(BosseFK);

		add(Panzarüstung = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Panzarüstung", Bosse.getModelle(), 5));
		add(Trophäenstange = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Trophäenstange", Bosse.getModelle(), 5));
		add(Waaaghbanner = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Waaaghbanner", Bosse.getModelle(), 15));
		add(Munigrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Munigrotz", Bosse.getModelle(), 3));

		seperator();

		add(Dok = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dok", 30));
		add(Grotassistänt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Grotassistänt", 5));
		add(CybOrkKörpa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Cybork-Körpa", 5, Bosse.getModelle()));

		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", Bosse.getModelle()*5));

		seperator();

		PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, "ORPikkUpKammer", "Pikk Up");
		PikkUp.initKammer();
		add(PikkUp);

		Kampfpanza = new RuestkammerStarter(ID, randAbstand, cnt, "ORKampfpanzaKammer", "Kampfpanza");
		Kampfpanza.initKammer();
		add(Kampfpanza);

		complete();
	}

	@Override
	public void deleteYourself() {
		if ( spezialAuswahl){
			BuildaHQ.addToInformationVector("ORBosse", -1);
		}
		super.deleteYourself();
	}
	
	//@OVERRIDE
	public void refreshen() {
		Bossbikaz.setAktiv(!Panzarüstung.isSelected());
		Panzarüstung.setAktiv(!Bossbikaz.isSelected());

		Grotassistänt.setAktiv(Dok.isSelected());
		CybOrkKörpa.setAktiv(Dok.isSelected());

		int abzugFürDok = (Dok.isSelected() ? 1 : 0);

		BosseFK.setMaxAnzahl(Bosse.getModelle() - abzugFürDok);
		BosseCC.setMaxAnzahl(Bosse.getModelle() - abzugFürDok);
		Panzarüstung.setMaxAnzahl(Bosse.getModelle() - abzugFürDok);
		Trophäenstange.setMaxAnzahl(Bosse.getModelle() - abzugFürDok);
		Waaaghbanner.setMaxAnzahl(Bosse.getModelle() - abzugFürDok);
		Munigrotz.setMaxAnzahl(Bosse.getModelle() - abzugFürDok);

		Bossbikaz.setModelle(Bosse.getModelle());
		Stikkbombz.setModelle(Bosse.getModelle());
		CybOrkKörpa.setModelle(Bosse.getModelle());

		PikkUp.setAktiv(!Kampfpanza.isSelected() && !Bossbikaz.isSelected());
		Kampfpanza.setAktiv(!PikkUp.isSelected() && !Bossbikaz.isSelected());
		Kampfpanza.getPanel().setLocation((int) Kampfpanza.getPanel().getLocation().getX(), (int) PikkUp.getPanel().getLocation().getY() + PikkUp.getPanel().getSize().height);
	
		//Da die Kategorie erst nach dem Erstellen des Objekts geändert wird, muss die Kategorieabfrage beim refresh erfolgen. 
		//Das spezialAuswahl-Flag sorgt dafür, dass  Bosse nur einmal in den InformationVector eingefügt wird
		if ( !spezialAuswahl && kategorie == 3){
			spezialAuswahl=true;
			BuildaHQ.addToInformationVector("ORBosse", 1);
			RefreshListener.fireRefresh();
		}

		int maxBosse = BuildaHQ.getCountFromInformationVector("ORWaaghboss");

		if(BuildaHQ.getCountFromInformationVector("ORBosse") > maxBosse && kategorie == 3) {
			setFehlermeldung("Max. " + maxBosse + " Boss-Mobs");
		} else {
			setFehlermeldung("");
		}
		
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0 && !CybOrkKörpa.isSelected()){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(Bosse.getModelle()*5);
		
		if(madDokCybork.isSelected()){
			CybOrkKörpa.setAktiv(false);
		} else if (Dok.isSelected()){
			CybOrkKörpa.setAktiv(true);
		}
		
	}

}
