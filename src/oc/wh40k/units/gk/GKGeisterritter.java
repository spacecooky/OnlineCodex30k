package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class GKGeisterritter extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsEinzelUpgrade banner;

	public GKGeisterritter() {
		name = "Geisterritter"; //-Trupp\n";
		grundkosten = 0;
		//überschriftSetzen = true;
        setEintragsCNT(0.0);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Geisterritter", 1, 5, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/GKGeisterritter.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 0));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 5));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		add(banner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bruderschafts-Banner", 25));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        
		int subtractor =  banner.isSelected()? 1 : 0;

		o1.setMaxAnzahl(squad.getModelle() - subtractor); // heavy weapon
		o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - subtractor);
		o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - subtractor);
	}

}
