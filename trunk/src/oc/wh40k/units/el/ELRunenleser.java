package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ELRunenleser extends Eintrag {

	AnzahlPanel Runenleser;
	OptionsEinzelZaehler boss1;
	OptionsEinzelZaehler boss2;
	OptionsEinzelUpgrade boss5;
	OptionsZaehlerGruppe oG;
	RuestkammerStarter Serpent;

	public ELRunenleser() {
		this.setEintragsCNT(0);
		name = "Runenleser";
		grundkosten = 0;

		Runenleser = new AnzahlPanel(ID, randAbstand, cnt, "Runenleser", 3, 10, 25);
		add(Runenleser);

		add(ico = new oc.Picture("oc/wh40k/images/ELRunenleser.jpg"));
		

		seperator();

		add(boss2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Phantomseher", Runenleser.getModelle(), 6));
		add(boss1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Runenspeer", Runenleser.getModelle(), 3));

		seperator();

		add(boss5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Eldar-Jetbikes", 20, Runenleser.getModelle()));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nebelschleier", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flammen der Wut", 10));
		ogE.addElement(new OptionsGruppeEintrag("Stählerne Entschl.", "Stählerne Entschlossenheit", 5));
		ogE.addElement(new OptionsGruppeEintrag("Khaines Segen", 15));
		oG = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, Runenleser.getModelle());
		add(oG);

		seperator();

		Serpent = new RuestkammerStarter(ID, randAbstand, cnt, "ELSerpentKammer", "Serpent");
		Serpent.initKammer();
		add(Serpent);

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		boss1.setMaxAnzahl(Runenleser.getModelle());
		boss2.setMaxAnzahl(Runenleser.getModelle());
		oG.setMaxAnzahl(Runenleser.getModelle());

		boss5.setModelle(Runenleser.getModelle());
                Serpent.setAktiv(!boss5.isSelected());
                boss5.setAktiv(!Serpent.isSelected());
	}

}















