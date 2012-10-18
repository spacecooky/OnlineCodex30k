package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.whfb.armies.VOLKSkaven;

public class SKGossenlaeufer extends Eintrag {

	AnzahlPanel squad;

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oe5;
	OptionsEinzelUpgrade oe6;
	
	OptionsEinzelUpgrade oeC;
	
	boolean set = false;
	boolean weapon = false;
	
	public SKGossenlaeufer() {
		name = BuildaHQ.translate("Gossenläufer");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gossenläufer"), 5, 15, 12);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		add(oe1= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Fangnetz"), 0));
		add(oe2= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schleudern"), 1));
		add(oe3= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Giftattacken"), 5));
		
		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 12));
		
		seperator();
		
		add(oe4= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Rauchbomben"), 10));
		add(oe5= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Tränenklinge"), 30));
		
		seperator();
		
		add(oe6= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Warpbohrer"), 60));
		
		complete();
	}

	@Override
	public void refreshen() {
		oe2.setPreis(squad.getModelle() * 1);
		oe3.setPreis(squad.getModelle() * 5);
		
		oe4.setAktiv(oeC.isSelected());
		oe5.setAktiv(oeC.isSelected());
		
		if(!set)VOLKSkaven.GUTTERRUNNERS ++;						
		set = true;
		
		if(oe6.getKosten() > 0){
			if(!weapon){
				VOLKSkaven.GUTTERRUNNERSWT ++;
			}
			weapon = true;
		}else{
			if(weapon){
				weapon = false;
				VOLKSkaven.GUTTERRUNNERSWT --;
			}
		}
					
		double d = (Double.valueOf(VOLKSkaven.GUTTERRUNNERS).doubleValue()/2) + 0.5;
		int i = (int)d;		

		if(VOLKSkaven.GUTTERRUNNERSWT > i){
			setFehlermeldung(BuildaHQ.translate("Waffenteams")+": 0-"+i);
		}else{
			try {
				setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 6 : 3);
			} catch (Exception e){
				setUnikat(true, 3);
			}
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}

	@Override
	public void deleteYourself() {
		VOLKSkaven.GUTTERRUNNERS --;
		if(weapon){
			VOLKSkaven.GUTTERRUNNERSWT --;
		}
		super.deleteYourself();
	}
}
