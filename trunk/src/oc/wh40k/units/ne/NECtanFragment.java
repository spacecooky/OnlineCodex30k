package oc.wh40k.units.ne;

import java.util.Vector;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;

public class NECtanFragment extends Eintrag {

	OptionsUpgradeGruppeUnique o1;

	public NECtanFragment() {
		name = "C'tan Fragment";
		grundkosten = 185;

		add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));
		
		seperator();

        ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag("Entropische Berührung", 10));
		ogE.addElement(new OptionsGruppeEintrag("Herr des Feuers", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sengende Splitter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Geisterstaubwolke", 20));
		ogE.addElement(new OptionsGruppeEintrag("Weltenformer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Lebende Singularität", 30));
		ogE.addElement(new OptionsGruppeEintrag("Realitätsbeben", 35));
		ogE.addElement(new OptionsGruppeEintrag("Große Illusion", 40));
		ogE.addElement(new OptionsGruppeEintrag("Zeitstrahl", 40));
		ogE.addElement(new OptionsGruppeEintrag("Transdim. Energieblitz", "Transdimensionaler Energieblitz", 45));
		ogE.addElement(new OptionsGruppeEintrag("Todesblick", 50));
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE, 2));
        
		complete();
	}

	@Override
	public void refreshen() {
        o1.setLegal(o1.getAnzahl() == 2);
	}

}
