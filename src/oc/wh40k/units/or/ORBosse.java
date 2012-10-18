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
	OptionsEinzelZaehler Panzar�stung;
	OptionsEinzelZaehler Troph�enstange;
	OptionsEinzelZaehler Waaaghbanner;
	OptionsEinzelZaehler Munigrotz;
	OptionsEinzelUpgrade Dok;
	OptionsEinzelUpgrade Grotassist�nt;
	OptionsEinzelUpgrade CybOrkK�rpa;
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
		ogE.addElement(new OptionsGruppeEintrag("Energiekrall�", 25));
		BosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(BosseCC);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bazzukka-Kombi", 5));
		ogE.addElement(new OptionsGruppeEintrag("Gitbrenna-Kombi", 5));
		ogE.addElement(new OptionsGruppeEintrag("sync. Wumme", 5));
		BosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(BosseFK);

		add(Panzar�stung = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Panzar�stung", Bosse.getModelle(), 5));
		add(Troph�enstange = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Troph�enstange", Bosse.getModelle(), 5));
		add(Waaaghbanner = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Waaaghbanner", Bosse.getModelle(), 15));
		add(Munigrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Munigrotz", Bosse.getModelle(), 3));

		seperator();

		add(Dok = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dok", 30));
		add(Grotassist�nt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Grotassist�nt", 5));
		add(CybOrkK�rpa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Cybork-K�rpa", 5, Bosse.getModelle()));

		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-K�rpa", Bosse.getModelle()*5));

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
		Bossbikaz.setAktiv(!Panzar�stung.isSelected());
		Panzar�stung.setAktiv(!Bossbikaz.isSelected());

		Grotassist�nt.setAktiv(Dok.isSelected());
		CybOrkK�rpa.setAktiv(Dok.isSelected());

		int abzugF�rDok = (Dok.isSelected() ? 1 : 0);

		BosseFK.setMaxAnzahl(Bosse.getModelle() - abzugF�rDok);
		BosseCC.setMaxAnzahl(Bosse.getModelle() - abzugF�rDok);
		Panzar�stung.setMaxAnzahl(Bosse.getModelle() - abzugF�rDok);
		Troph�enstange.setMaxAnzahl(Bosse.getModelle() - abzugF�rDok);
		Waaaghbanner.setMaxAnzahl(Bosse.getModelle() - abzugF�rDok);
		Munigrotz.setMaxAnzahl(Bosse.getModelle() - abzugF�rDok);

		Bossbikaz.setModelle(Bosse.getModelle());
		Stikkbombz.setModelle(Bosse.getModelle());
		CybOrkK�rpa.setModelle(Bosse.getModelle());

		PikkUp.setAktiv(!Kampfpanza.isSelected() && !Bossbikaz.isSelected());
		Kampfpanza.setAktiv(!PikkUp.isSelected() && !Bossbikaz.isSelected());
		Kampfpanza.getPanel().setLocation((int) Kampfpanza.getPanel().getLocation().getX(), (int) PikkUp.getPanel().getLocation().getY() + PikkUp.getPanel().getSize().height);
	
		//Da die Kategorie erst nach dem Erstellen des Objekts ge�ndert wird, muss die Kategorieabfrage beim refresh erfolgen. 
		//Das spezialAuswahl-Flag sorgt daf�r, dass  Bosse nur einmal in den InformationVector eingef�gt wird
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
		
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0 && !CybOrkK�rpa.isSelected()){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(Bosse.getModelle()*5);
		
		if(madDokCybork.isSelected()){
			CybOrkK�rpa.setAktiv(false);
		} else if (Dok.isSelected()){
			CybOrkK�rpa.setAktiv(true);
		}
		
	}

}
