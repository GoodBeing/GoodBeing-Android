package com.landvibe.goodbeing.goodbeing_android.FAQ;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.Login.LoginActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-17.
 */
public class FaqActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {

    Context mContext;

    private Intent intent;
    private RecyclerView faqRecycleView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<FaqItem> faqItemArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        intent = getIntent();


        mContext = getApplicationContext();

        faqRecycleView = (RecyclerView)findViewById(R.id.faq_recyclerview);
        faqRecycleView.setHasFixedSize(true);

        faqItemArrayList = new ArrayList<FaqItem>();

        String question[] = {"질문1. 환경호르몬이란 무엇입니까?","질문2. 건강한 아기를 출산하는 데 환경호르몬이 얼마나 영향을 미치나요?",
                            "질문3. 아기가 태어나는 데 뿐만 아니라 어린이, 청소년에도 환경호르몬이 영향을 미치나요?", "질문4. 공동체 건강과 환경호르몬은 어떤 관계인가요?",
                            "질문5. 계란에 농약(피프로닐) 검출파동에서 보는 것처럼 유해물질에 전혀 노출되지 않아야 좋은 건가요? ","질문6. 굳빙체크를 했는데 점수가 너무 높아서 당황했습니다. 어떻게 해야 하나요?",
                            "질문7. 굳빙체크와 생체 시료분석을 마쳤습니다. 그럼 환경호르몬에서 완전히 해독된 건가요?","질문8. 굳빙체크와 생체 시료분석은 한 번만 하면 되나요?"};

        String answer[] = {"몸 속에서 분비되는 내분비 즉 호르몬과 화학적 구조가 유사한 외부 물질로 호르몬이 하는 정상적 기능, 성장, 분화, 면역, 생식에 관한 질서를 파괴하는 환경 중 유해물질입니다."
        ,"우선 건강한 정자, 난자의 활동을 저해하거나 생성되지 못하게 할 수 있어 난임과 불임을 유발할 수 있어요.  게다가 고령임신이나 유해환경작업근로자의 경우, 더 기형아 유발 등 건강한 아기를 낳는데 많은 위험이 높습니다."
        ,"맞습니다. 성장, 발달을 계속하는 어린이, 청소년들도 환경호르몬 노출시 감수성이 높은 고위험군입니다. 현재 비스페놀 A 농도와 청소년우울증 증가 등의 보고가 있습니다."
        ,"학교나 직장의 단체급식이나 공동체활동이 많은 요즘, 환경호르몬은 주로 먹는 것, 식이, 조리과정을 통해 노출되기 싶기 때문에 같은 생활(직장, 학교 등)을 하는 공동체에서는 공동으로 환경호르몬(내분비장애물질)에 노출됩니다. 그러므로 환경호르몬에 노출을 차단하기 위하여 수시로 노출정도를 체크하는게 바람직합니다. 단 같은 양에 노출에 대하여 개인차(대사 등)가 있으므로 노출량에 대한 효율적 규제에도 공동체 검진에 환경호르몬 노출 측정을 추가하면 좋"
        ,"전혀 노출되지 않으면 이상적이지요. 하지만 현대인은 그럴 수 없어요. 국가에서는 그래서 규제농도라는 걸 설정해서(평생 날마다 이정도 노출되어도 병을 유발하지 않은 일일 섭취허용량 등 규제농도라는 것이 있습니다) 자국민을 보호하지요. 그리고 우리는 다양한 물질에 날마다 노출됩니다. 그러므로 환경호르몬의 규제와 더불어 좋은 생활습관 특히 식습관은 유해물질의 노출에 적절한 해독에 도움이 됩니다."
        ,"소변이나 혈액(숙명여자대학교 독성학교실 굳빙센터방문)하거나 생체시료를 굳빙센터로 보내주세요."
        ,"생체 시료분석과 굳빙체를 통해 각 영역별 전문가들이 해독과 건강을 위한 개인 맞춤형 컨설팅을 해드립니다. 그러면 처방된 개인 컨설팅에 맞추어 생활하시고, 1-2개월 간격으로 재검사를 합니다."
        ,"굳빙센터 멤버십에 가입되신 회원은 굳빙센터의 스마트 폰을 통해 건강관리를 해드립니다."};

        for(int i = 0; i < 8; i++) {
            FaqItem item = new FaqItem(question[i], answer[i]);
            faqItemArrayList.add(item);
        }

        layoutManager = new LinearLayoutManager(this);
        faqRecycleView.setLayoutManager(layoutManager);

        adapter = new FaqAdapter(faqItemArrayList);
        faqRecycleView.addOnItemTouchListener(new FaqRecyclerViewOnItemClickListener(this,faqRecycleView, new FaqRecyclerViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if(view.findViewById(R.id.faq_answer_tv).getVisibility()==view.findViewById(R.id.faq_answer_tv).GONE)
                {
                    view.findViewById(R.id.faq_answer_tv).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.faq_img_ic).setBackgroundResource(R.drawable.ic_faq_close);
                }
                else
                {
                    view.findViewById(R.id.faq_answer_tv).setVisibility(View.GONE);
                    view.findViewById(R.id.faq_img_ic).setBackgroundResource(R.drawable.ic_faq_expand);
                }


            }
            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


        faqRecycleView.setAdapter(adapter);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        intent = new Intent();

        if (id == R.id.nav_intro) {
            intent.setClassName(this , IntroActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_history) {
            intent.setClassName(this , HistoryActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_surveyWrite) {
            intent.setClassName(this , SurveySearchActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_sample) {
            intent.setClassName(this , SampleMainActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_consulting) {
            intent.setClassName(this , LoginActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_faq) {
            intent.setClassName(this , FaqActivity.class.getName());
            startActivity(intent);
        }
        else if(id == R.id.nav_login)
        {
            intent.setClassName(this , LoginActivity.class.getName());
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

        intent = new Intent();
    }
}
