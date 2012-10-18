package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ELHornetSquadron extends Eintrag {

	AnzahlPanel Hornet;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsEinzelZaehler o2;
	OptionsEinzelZaehler o3;
	OptionsEinzelZaehler o5;

	public ELHornetSquadron() {

		name = "Hornet Squadron";

		grundkosten = 0;

		Hornet = new AnzahlPanel(ID, randAbstand, cnt, "Hornet", "Hornets", 1, 3, 65);
		add(Hornet);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/Vyperschwadron.gif"));
		

		ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 0));
                add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Hornet.getModelle()));
		ogE.addElement(new OptionsGruppeEintrag("Impulslaser", 10));
		ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sternenkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Laserlanze", 25));
		ogE.addElement(new OptionsGruppeEintrag("Pulsar", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Hornet.getModelle()));

		seperator(15);
                
		o3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Vektorschubdüsen", Hornet.getModelle(), 20);
		add(o3);

		o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Holofeld", Hornet.getModelle(), 35);
		add(o2);

		o5 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Seelenstein", Hornet.getModelle(), 10);
		add(o5);

		complete();
	}

	//@OVERRIDE
	public void refreshen() {

		o1.setMaxAnzahl(Hornet.getModelle() * 2);
		o1x.setMaxAnzahl(Hornet.getModelle() * 2);
		o2.setMaxAnzahl(Hornet.getModelle());
		o3.setMaxAnzahl(Hornet.getModelle());
		o5.setMaxAnzahl(Hornet.getModelle());
	
                o1x.setAnzahl(0, o1x.getMaxAnzahl() - o1.getAnzahl());
	}
}
