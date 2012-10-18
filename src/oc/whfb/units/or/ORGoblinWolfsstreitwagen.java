package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORGoblinWolfsstreitwagen extends Eintrag {
	
	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public ORGoblinWolfsstreitwagen() {
		name = BuildaHQ.translate("Goblin-Wolfsstreitwagen");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Goblin-Wolfsstreitwagen"), 1, 3, 50);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Zusätzlicher Goblin"), 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Zusätzlicher Riesenwolf"), 5));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 5);
		oe2.setPreis(squad.getModelle() * 5);
		
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
