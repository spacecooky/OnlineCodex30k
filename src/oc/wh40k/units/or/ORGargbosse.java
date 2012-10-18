package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class ORGargbosse extends Eintrag {

	AnzahlPanel Gargbosse;
	OptionsZaehlerGruppe GargbosseFK;
	RuestkammerStarter PikkUp;
	RuestkammerStarter Kampfpanza;
	boolean spezialAuswahl = false;
	OptionsEinzelUpgrade madDokCybork;

	public ORGargbosse() {

		grundkosten = 0;

		name = "Gargbosse";





		Gargbosse = new AnzahlPanel(ID, randAbstand, cnt, "Gargbosse", 3, 10, 40);

		add(Gargbosse);





		add(ico = new oc.Picture("oc/wh40k/images/Gargbosse.gif"));

		seperator();



		ogE.addElement(new OptionsGruppeEintrag("Bazzukka-Kombi", "Bazzukka-Kombiwaffe", 5));

		ogE.addElement(new OptionsGruppeEintrag("Gitbrenna-Kombi", "Gitbrenna-Kombiwaffe", 5));



		GargbosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3);

		add(GargbosseFK);

		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", Gargbosse.getModelle()*5));

		seperator();

		PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, "ORPikkUpKammer", "Pikk Up");

		PikkUp.initKammer();

		add(PikkUp);





		Kampfpanza = new RuestkammerStarter(ID, randAbstand, cnt, "ORKampfpanzaKammer", "Kampfpanza");

		Kampfpanza.initKammer();

		Kampfpanza.setSeperator(0);

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

		GargbosseFK.setMaxAnzahl(Gargbosse.getModelle());

		PikkUp.setAktiv(Gargbosse.getModelle() <= 6 && !Kampfpanza.isSelected());

		Kampfpanza.setAktiv(!PikkUp.isSelected());

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


		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(Gargbosse.getModelle()*5);

	}
}
