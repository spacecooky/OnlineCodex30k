package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DARavenwingUnterstuetzungsschwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler o1;
	OptionsEinzelUpgrade o2;
	OptionsUpgradeGruppe o3;

	public DARavenwingUnterstuetzungsschwadron() {
		name = "Ravenwing-Unterstützungsschwadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Land Speeder", 1, 5, 65);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DARavenwingSupportSquadron.gif"));

		seperator(12);

		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Multimelter", squad.getModelle(), 0));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Typhoon Raketenwerfer", 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 35));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());

		if (squad.getModelle() == 1 && o2.isSelected() && o3.isSelected()) {
			o2.setSelected(false);
		} // 2 Spezialwaffen und nur 1 Landspeeder geht net
	}

}
