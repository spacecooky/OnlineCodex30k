package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;

public class ORGargbot extends Eintrag {

	AnzahlPanel Gargbot;
	OptionsZaehlerGruppe GargbotFK;
	OptionsEinzelUpgrade Grothälfaz;
	OptionsEinzelUpgrade Panzaplattenz;
	boolean spezialAuswahl = false;

	public ORGargbot() {

		kategorie = 5;
		name = "Gargbot";
		grundkosten = 75;
		
		add(ico = new oc.Picture("oc/wh40k/images/Gargbot.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 5));
		ogE.addElement(new OptionsGruppeEintrag("Bazzukka", 10));
		ogE.addElement(new OptionsGruppeEintrag("Megablasta", 15));
		ogE.addElement(new OptionsGruppeEintrag("Gitbrenna", 5));
		ogE.addElement(new OptionsGruppeEintrag("Cybotnahkampfwaffe", 15));

		GargbotFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2);
		add(GargbotFK);

		seperator(15);

		Grothälfaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grothälfaz", 5);
		add(Grothälfaz);

		Panzaplattenz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 10);
		add(Panzaplattenz);

		complete();

	}

	@Override
	public void deleteYourself() {
		if ( spezialAuswahl){
			BuildaHQ.addToInformationVector("ORGargbot", -1);
		}
		super.deleteYourself();
	}

	//@OVERRIDE
	public void refreshen() {

		GargbotFK.setLegal(GargbotFK.getAnzahl() == 2);

		//Da die Kategorie erst nach dem Erstellen des Objekts geändert wird, muss die Kategorieabfrage beim refresh erfolgen. 
		//Das spezialAuswahl-Flag sorgt dafür, dass der Gargbot nur einmal in den InformationVector eingefügt wird
		if ( !spezialAuswahl && kategorie == 3){
			spezialAuswahl=true;
			BuildaHQ.addToInformationVector("ORGargbot", 1);
			RefreshListener.fireRefresh();
		}

		int maxGargbots = BuildaHQ.getCountFromInformationVector("ORBigmek");

		if(BuildaHQ.getCountFromInformationVector("ORGargbot") > maxGargbots && kategorie == 3) {
			setFehlermeldung("Max. " + maxGargbots + " Gargbots");
		} else if(BuildaHQ.getCountFromInformationVector("ORZhadsnark") > 0) {
			setFehlermeldung("Zhadsnark: Keine Bots!");
		} else {
			setFehlermeldung("");
		}
	}
}























